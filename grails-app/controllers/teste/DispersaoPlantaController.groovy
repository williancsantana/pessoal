package teste

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DispersaoPlantaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond DispersaoPlanta.list(params), model:[dispersaoPlantaCount: DispersaoPlanta.count()]
    }

    def show(DispersaoPlanta dispersaoPlanta) {
        respond dispersaoPlanta
    }

    def create() {
        respond new DispersaoPlanta(params)
    }

    @Transactional
    def save(DispersaoPlanta dispersaoPlanta) {
        if (dispersaoPlanta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (dispersaoPlanta.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond dispersaoPlanta.errors, view:'create'
            return
        }

        dispersaoPlanta.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'dispersaoPlanta.label', default: 'DispersaoPlanta'), dispersaoPlanta.id])
                redirect dispersaoPlanta
            }
            '*' { respond dispersaoPlanta, [status: CREATED] }
        }
    }

    def edit(DispersaoPlanta dispersaoPlanta) {
        respond dispersaoPlanta
    }

    @Transactional
    def update(DispersaoPlanta dispersaoPlanta) {
        if (dispersaoPlanta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (dispersaoPlanta.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond dispersaoPlanta.errors, view:'edit'
            return
        }

        dispersaoPlanta.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'dispersaoPlanta.label', default: 'DispersaoPlanta'), dispersaoPlanta.id])
                redirect dispersaoPlanta
            }
            '*'{ respond dispersaoPlanta, [status: OK] }
        }
    }

    @Transactional
    def delete(DispersaoPlanta dispersaoPlanta) {

        if (dispersaoPlanta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        dispersaoPlanta.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'dispersaoPlanta.label', default: 'DispersaoPlanta'), dispersaoPlanta.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dispersaoPlanta.label', default: 'DispersaoPlanta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
