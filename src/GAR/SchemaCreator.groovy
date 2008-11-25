
try {
    println "Criando tabela users..."
    def db = groovy.sql.Sql.newInstance('jdbc:postgresql://localhost:5432/gfitadm','postgres','postgres','org.postgresql.Driver')
    db.execute '''
        DROP TABLE IF EXISTS users;
        CREATE TABLE users (
            id SERIAL,
            login VARCHAR(20),
            password VARCHAR(20)
        );
    '''

    // Insira novas modificacoes no schema aqui

    println "O banco de dados foi criado com sucesso!"
}
catch(Exception e) {
    println "Erro ao tentar criar a tabela users: "+e.toString()
}


