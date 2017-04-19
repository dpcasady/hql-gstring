package hql.gstring

import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class BookHqlSpec extends Specification {

    void "test findAll with hardcoded class name"() {
        expect:
            Book.findAll("from Book") == []
    }

    void "test findAll with interpolated class name"() {
        given:
            String className = "Book"
        expect:
            Book.findAll("from $className") == [] // throws GrailsQueryException
    }
}
