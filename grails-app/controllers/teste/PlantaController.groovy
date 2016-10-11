package teste

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PlantaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Planta.list(params), model:[plantaCount: Planta.count()]
    }

    def show(Planta planta) {
        respond planta
    }

    def create() {
        respond new Planta(params)
    }

    @Transactional
    def save(Planta planta) {
        if (planta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (planta.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond planta.errors, view:'create'
            return
        }

        planta.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'planta.label', default: 'Planta'), planta.id])
                redirect planta
            }
            '*' { respond planta, [status: CREATED] }
        }
    }

    def edit(Planta planta) {
        respond planta
    }

    @Transactional
    def update(Planta planta) {
        if (planta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (planta.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond planta.errors, view:'edit'
            return
        }

        planta.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'planta.label', default: 'Planta'), planta.id])
                redirect planta
            }
            '*'{ respond planta, [status: OK] }
        }
    }

    @Transactional
    def delete(Planta planta) {

        if (planta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        planta.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'planta.label', default: 'Planta'), planta.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'planta.label', default: 'Planta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
