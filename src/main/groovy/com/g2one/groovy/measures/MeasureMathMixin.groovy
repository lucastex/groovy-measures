package com.g2one.groovy.measures

import javax.measure.Measure
import javax.measure.unit.NonSI
import javax.measure.unit.SI

public class MeasureMathMixin {

    static isTime(Measure self) {
        self.unit in [NonSI.MINUTE, NonSI.HOUR, NonSI.DAY]
    }

    static plus(Measure self, Measure other) {
        // TODO there must be something in JScience to support adding Measures...
        if (self.isTime()) {
            def selfInMinutes = self.doubleValue(NonSI.MINUTE)
            def otherInMinutes = other.doubleValue(NonSI.MINUTE)
            return Measure.valueOf(selfInMinutes + otherInMinutes, NonSI.MINUTE)
        } else {
            def selfInMeters = self.doubleValue(SI.METER)
            def otherInMeters = other.doubleValue(SI.METER)
            return Measure.valueOf(selfInMeters + otherInMeters, SI.METER)
        }
    }

    static minus(Measure self, Measure other) {
        // TODO there must be something in JScience to support subtracting Measures...
        if (self.isTime()) {
            def selfInMinutes = self.doubleValue(NonSI.MINUTE)
            def otherInMinutes = other.doubleValue(NonSI.MINUTE)
            return Measure.valueOf(selfInMinutes - otherInMinutes, NonSI.MINUTE)
        } else {
            def selfInMeters = self.doubleValue(SI.METER)
            def otherInMeters = other.doubleValue(SI.METER)
            return Measure.valueOf(selfInMeters - otherInMeters, SI.METER)
        }
    }

    static multiply(Measure self, Number number) {
        if (self.isTime()) {
            def selfInMinutes = self.doubleValue(NonSI.MINUTE)
            return Measure.valueOf(selfInMinutes * number, NonSI.MINUTE)
        } else {
            def selfInMeters = self.doubleValue(SI.METER)
            return Measure.valueOf(selfInMeters * number, SI.METER)
        }
    }

    static div(Measure self, Number number) {
        if (self.isTime()) {
            def selfInMinutes = self.doubleValue(NonSI.MINUTE)
            return Measure.valueOf(selfInMinutes / number, NonSI.MINUTE)
        } else {
            def selfInMeters = self.doubleValue(SI.METER)
            return Measure.valueOf(selfInMeters / number, SI.METER)
        }
    }
}