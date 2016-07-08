package org.cqframework.cql.elm.execution;

import org.apache.commons.lang3.NotImplementedException;
import org.cqframework.cql.execution.Context;
import org.cqframework.cql.runtime.DateTime;
import org.cqframework.cql.runtime.Time;

import java.math.BigDecimal;

/**
 * Created by Bryn on 5/25/2016.
 */
public class MaxValueEvaluator extends MaxValue {

    @Override
    public Object evaluate(Context context) {
        switch (valueType.getLocalPart()) {
            case "Integer": return org.cqframework.cql.runtime.Interval.maxValue(Integer.class);
            case "Decimal": return org.cqframework.cql.runtime.Interval.maxValue(BigDecimal.class);
            case "Quantity": return org.cqframework.cql.runtime.Interval.maxValue(org.cqframework.cql.runtime.Quantity.class);
            case "DateTime": return org.cqframework.cql.runtime.Interval.maxValue(DateTime.class);
            case "Time": return org.cqframework.cql.runtime.Interval.maxValue(Time.class);
            default: throw new NotImplementedException(String.format("maxValue not implemented for type %s", valueType.getLocalPart()));
        }
    }
}
