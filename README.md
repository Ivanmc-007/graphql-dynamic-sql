Web interface 

Example graphql request (host example: http://localhost:8080/graphiql):

query {
    department(id: 1) {
        id
        name
        organization {
            id
            name
        }
        # employees {
        #   id
        #   firstName
        #   lastName
        # }
    }
}