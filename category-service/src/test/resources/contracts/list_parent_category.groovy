package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "list parent category"
    description "it should list parent category"

    request {
        url "/api/v1/parent-category"

        headers {
            header(contentType(), applicationJson())
        }

        method GET()

    }

    response {
        status OK()

        headers {
            header(contentType(), applicationJson())
        }

        //TODO response body eklenecek.
    }

}