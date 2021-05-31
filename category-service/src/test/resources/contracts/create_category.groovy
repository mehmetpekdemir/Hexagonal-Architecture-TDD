package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "Test create category"
    description "it should success category create when category called with valid request"

    request {
        url "/api/v1/category"

        headers {
            header(contentType(), applicationJson())
        }

        method POST()

        body("""
                        {
                            "name": "category name"
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
                        "id" : 1,
                        "name" : "category name"
                    },
                    "errors": null
                }

        """


        )
    }

}