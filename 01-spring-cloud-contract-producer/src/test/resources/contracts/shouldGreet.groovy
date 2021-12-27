import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method(GET())
        url("/hello")
    }
    response {
        status(OK())
        headers{
            contentType(applicationJson())
            body("hello")
        }
    }
}