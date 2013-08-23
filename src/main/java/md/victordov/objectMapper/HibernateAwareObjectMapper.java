package md.victordov.objectMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/22/13
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class HibernateAwareObjectMapper extends ObjectMapper {

    public HibernateAwareObjectMapper(){
        registerModule(new Hibernate4Module());
        this.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        //this.enable(SerializationFeature.EAGER_SERIALIZER_FETCH);
    }


}
