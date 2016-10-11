package teste

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CategoriaAmeacaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CategoriaAmeaca.list(params), model:[categoriaAmeacaCount: CategoriaAmeaca.count()]
    }

    def show(CategoriaAmeaca categoriaAmeaca) {
        respond categoriaAmeaca
    }

    def create() {
        respond new CategoriaAmeaca(params)
    }

    @Transactional
    def save(CategoriaAmeaca categoriaAmeaca) {
        if (categoriaAmeaca == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (categoriaAmeaca.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond categoriaAmeaca.errors, view:'create'
            return
        }

        categoriaAmeaca.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'categoriaAmeaca.label', default: 'CategoriaAmeaca'), categoriaAmeaca.id])
                redirect categoriaAmeaca
            }
            '*' { respond categoriaAmeaca, [status: CREATED] }
        }
    }

    def edit(CategoriaAmeaca categoriaAmeaca) {
        respond categoriaAmeaca
    }

    @Transactional
    def update(CategoriaAmeaca categoriaAmeaca) {
        if (categoriaAmeaca == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (categoriaAmeaca.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond categoriaAmeaca.errors, view:'edit'
            return
        }

        categoriaAmeaca.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'categoriaAmeaca.label', default: 'CategoriaAmeaca'), categoriaAmeaca.id])
                redirect categoriaAmeaca
            }
            '*'{ respond categoriaAmeaca, [status: OK] }
        }
    }

    @Transactional
    def delete(CategoriaAmeaca categoriaAmeaca) {

        if (categoriaAmeaca == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        categoriaAmeaca.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'categoriaAmeaca.label', default: 'CategoriaAmeaca'), categoriaAmeaca.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'categoriaAmeaca.label', default: 'CategoriaAmeaca'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
