package teste

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PlantaSucessaoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PlantaSucessao.list(params), model:[plantaSucessaoCount: PlantaSucessao.count()]
    }

    def show(PlantaSucessao plantaSucessao) {
        respond plantaSucessao
    }

    def create() {
        respond new PlantaSucessao(params)
    }

    @Transactional
    def save(PlantaSucessao plantaSucessao) {
        if (plantaSucessao == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (plantaSucessao.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond plantaSucessao.errors, view:'create'
            return
        }

        plantaSucessao.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'plantaSucessao.label', default: 'PlantaSucessao'), plantaSucessao.id])
                redirect plantaSucessao
            }
            '*' { respond plantaSucessao, [status: CREATED] }
        }
    }

    def edit(PlantaSucessao plantaSucessao) {
        respond plantaSucessao
    }

    @Transactional
    def update(PlantaSucessao plantaSucessao) {
        if (plantaSucessao == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (plantaSucessao.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond plantaSucessao.errors, view:'edit'
            return
        }

        plantaSucessao.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'plantaSucessao.label', default: 'PlantaSucessao'), plantaSucessao.id])
                redirect plantaSucessao
            }
            '*'{ respond plantaSucessao, [status: OK] }
        }
    }

    @Transactional
    def delete(PlantaSucessao plantaSucessao) {

        if (plantaSucessao == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        plantaSucessao.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'plantaSucessao.label', default: 'PlantaSucessao'), plantaSucessao.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'plantaSucessao.label', default: 'PlantaSucessao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
