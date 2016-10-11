package teste

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CotacaoPlantaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CotacaoPlanta.list(params), model:[cotacaoPlantaCount: CotacaoPlanta.count()]
    }

    def show(CotacaoPlanta cotacaoPlanta) {
        respond cotacaoPlanta
    }

    def create() {
        respond new CotacaoPlanta(params)
    }

    @Transactional
    def save(CotacaoPlanta cotacaoPlanta) {
        if (cotacaoPlanta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (cotacaoPlanta.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond cotacaoPlanta.errors, view:'create'
            return
        }

        cotacaoPlanta.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'cotacaoPlanta.label', default: 'CotacaoPlanta'), cotacaoPlanta.id])
                redirect cotacaoPlanta
            }
            '*' { respond cotacaoPlanta, [status: CREATED] }
        }
    }

    def edit(CotacaoPlanta cotacaoPlanta) {
        respond cotacaoPlanta
    }

    @Transactional
    def update(CotacaoPlanta cotacaoPlanta) {
        if (cotacaoPlanta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (cotacaoPlanta.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond cotacaoPlanta.errors, view:'edit'
            return
        }

        cotacaoPlanta.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'cotacaoPlanta.label', default: 'CotacaoPlanta'), cotacaoPlanta.id])
                redirect cotacaoPlanta
            }
            '*'{ respond cotacaoPlanta, [status: OK] }
        }
    }

    @Transactional
    def delete(CotacaoPlanta cotacaoPlanta) {

        if (cotacaoPlanta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        cotacaoPlanta.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'cotacaoPlanta.label', default: 'CotacaoPlanta'), cotacaoPlanta.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cotacaoPlanta.label', default: 'CotacaoPlanta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
