package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "create category"
    description "it should success category create when category called with valid request"

    request {
        url "/api/v1/category"

        headers {
            header(contentType(), applicationJson())
        }

        method POST()

        body("""
                    {
                        "parentId": "null",
                        "name": "laptop",
                        "description": "macbook pro m1 16gb ram 256gb hard disk ",
                        "status": "active"
                    }
                        """
        )
    }

    response {
        status CREATED()

        headers {
            header(contentType(), applicationJson())
        }

        body(
                """
                {
                    "data": {
                        "name": "laptop",
                        "description": "macbook pro m1 16gb ram 256gb hard disk ",
                        "status": "ACTIVE"
                    },
                    "errors": null
                }
        """
        )
    }

}