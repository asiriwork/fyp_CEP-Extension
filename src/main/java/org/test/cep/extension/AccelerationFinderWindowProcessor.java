package org.test.cep.extension;

import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.executor.function.FunctionExecutor;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.extension.annotation.SiddhiExtension;


@SiddhiExtension(namespace = "fyp", function = "acceleration")
public class AccelerationFinderWindowProcessor extends FunctionExecutor {
    Attribute.Type returnType = Attribute.Type.INT;
    @Override
    public void init(Attribute.Type[] types, SiddhiContext siddhiContext) {
    }

    @Override
    protected Object process(Object obj) {
        if (obj instanceof Object[]) {
            double [] value = new double[3];
            int i=0;
            int j=0;
            for (Object aObj : (Object[]) obj) {
                    value[i] = (double) Double.parseDouble(String.valueOf(aObj));
                    i++;
            }
            double acceleration = value[0]*1000/value[1];
            if(acceleration >= value[2]){
                return 1;
            }else
            return 0;
        } else {
            return obj.toString();
        }

    }

    @Override
    public void destroy() {
    }

    @Override
    public Attribute.Type getReturnType() {
        return returnType;
    }
}