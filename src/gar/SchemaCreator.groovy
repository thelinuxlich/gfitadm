package gar

/**
 *
 * @author thelinuxlich
 */
class SchemaCreator {

    def current_table

    static void main(args) {
        def sc = new SchemaCreator(args[0])
    }

    SchemaCreator(database) {
        try {
            def db = groovy.sql.Sql.newInstance(
                "jdbc:postgresql://localhost:5432/$database",
                'postgres',
                'postgres',
                'org.postgresql.Driver'
            )

            current_table = "users"
            println "Creating table $current_table..."

            db.execute '''
                DROP TABLE IF EXISTS users;
                CREATE TABLE users (
                    id SERIAL,
                    login VARCHAR(20),
                    password VARCHAR(20),
                    person_id INTEGER,
                    level_id INTEGER
                );
            '''

            db.execute '''
                ALTER TABLE users
                ADD CONSTRAINT id PRIMARY KEY(id);
            '''

            def sql = "INSERT INTO users(login,password) VALUES(?,?);"
            (1..10).each {
                db.execute sql, ["user"+it,"testpass"]
            }

            // Insira novas modificacoes no schema aqui

            println "Database created with sucess!"
        } catch(Exception e) {
            println "Table ERROR: $current_table: " + e.toString()
        }
    }
}