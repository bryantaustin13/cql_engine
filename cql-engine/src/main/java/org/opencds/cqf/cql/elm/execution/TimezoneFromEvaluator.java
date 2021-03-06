package org.opencds.cqf.cql.elm.execution;

import org.opencds.cqf.cql.exception.InvalidOperatorArgument;
import org.opencds.cqf.cql.execution.Context;
import org.opencds.cqf.cql.runtime.DateTime;
import org.opencds.cqf.cql.runtime.TemporalHelper;
import org.opencds.cqf.cql.runtime.Time;

/*
timezone from(argument DateTime) Decimal
timezone from(argument Time) Decimal

NOTE: this is within the purview of DateTimeComponentFrom
  Description available in that class
*/

public class TimezoneFromEvaluator extends org.cqframework.cql.elm.execution.TimezoneFrom {

    public static Object timezoneFrom(Object operand) {
        if (operand == null) {
            return null;
        }

        if (operand instanceof DateTime) {
            return TemporalHelper.zoneToOffset(((DateTime) operand).getDateTime().getOffset());
        }

        if (operand instanceof Time) {
            return TemporalHelper.zoneToOffset(((Time) operand).getTime().getOffset());
        }

        throw new InvalidOperatorArgument(
                "TimezoneFrom(DateTime) or TimezoneFrom(Time)",
                String.format("TimezoneFrom(%s)", operand.getClass().getName())
        );
    }

    @Override
    protected Object internalEvaluate(Context context) {
        Object operand = getOperand().evaluate(context);
        return timezoneFrom(operand);
    }
}
