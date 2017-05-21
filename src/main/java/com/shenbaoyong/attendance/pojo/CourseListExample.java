package com.shenbaoyong.attendance.pojo;

import java.util.ArrayList;
import java.util.List;

public class CourseListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseListExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTeacherNameIsNull() {
            addCriterion("teacher_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNotNull() {
            addCriterion("teacher_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameEqualTo(String value) {
            addCriterion("teacher_name =", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotEqualTo(String value) {
            addCriterion("teacher_name <>", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThan(String value) {
            addCriterion("teacher_name >", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_name >=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThan(String value) {
            addCriterion("teacher_name <", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("teacher_name <=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLike(String value) {
            addCriterion("teacher_name like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotLike(String value) {
            addCriterion("teacher_name not like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIn(List<String> values) {
            addCriterion("teacher_name in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotIn(List<String> values) {
            addCriterion("teacher_name not in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameBetween(String value1, String value2) {
            addCriterion("teacher_name between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotBetween(String value1, String value2) {
            addCriterion("teacher_name not between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andClassroomNameIsNull() {
            addCriterion("classroom_name is null");
            return (Criteria) this;
        }

        public Criteria andClassroomNameIsNotNull() {
            addCriterion("classroom_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassroomNameEqualTo(String value) {
            addCriterion("classroom_name =", value, "classroomName");
            return (Criteria) this;
        }

        public Criteria andClassroomNameNotEqualTo(String value) {
            addCriterion("classroom_name <>", value, "classroomName");
            return (Criteria) this;
        }

        public Criteria andClassroomNameGreaterThan(String value) {
            addCriterion("classroom_name >", value, "classroomName");
            return (Criteria) this;
        }

        public Criteria andClassroomNameGreaterThanOrEqualTo(String value) {
            addCriterion("classroom_name >=", value, "classroomName");
            return (Criteria) this;
        }

        public Criteria andClassroomNameLessThan(String value) {
            addCriterion("classroom_name <", value, "classroomName");
            return (Criteria) this;
        }

        public Criteria andClassroomNameLessThanOrEqualTo(String value) {
            addCriterion("classroom_name <=", value, "classroomName");
            return (Criteria) this;
        }

        public Criteria andClassroomNameLike(String value) {
            addCriterion("classroom_name like", value, "classroomName");
            return (Criteria) this;
        }

        public Criteria andClassroomNameNotLike(String value) {
            addCriterion("classroom_name not like", value, "classroomName");
            return (Criteria) this;
        }

        public Criteria andClassroomNameIn(List<String> values) {
            addCriterion("classroom_name in", values, "classroomName");
            return (Criteria) this;
        }

        public Criteria andClassroomNameNotIn(List<String> values) {
            addCriterion("classroom_name not in", values, "classroomName");
            return (Criteria) this;
        }

        public Criteria andClassroomNameBetween(String value1, String value2) {
            addCriterion("classroom_name between", value1, value2, "classroomName");
            return (Criteria) this;
        }

        public Criteria andClassroomNameNotBetween(String value1, String value2) {
            addCriterion("classroom_name not between", value1, value2, "classroomName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNull() {
            addCriterion("course_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("course_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("course_name =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("course_name <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("course_name >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_name >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("course_name <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("course_name <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("course_name like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("course_name not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("course_name in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("course_name not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("course_name between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("course_name not between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIdIsNull() {
            addCriterion("course_time_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIdIsNotNull() {
            addCriterion("course_time_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIdEqualTo(String value) {
            addCriterion("course_time_id =", value, "courseTimeId");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIdNotEqualTo(String value) {
            addCriterion("course_time_id <>", value, "courseTimeId");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIdGreaterThan(String value) {
            addCriterion("course_time_id >", value, "courseTimeId");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIdGreaterThanOrEqualTo(String value) {
            addCriterion("course_time_id >=", value, "courseTimeId");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIdLessThan(String value) {
            addCriterion("course_time_id <", value, "courseTimeId");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIdLessThanOrEqualTo(String value) {
            addCriterion("course_time_id <=", value, "courseTimeId");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIdLike(String value) {
            addCriterion("course_time_id like", value, "courseTimeId");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIdNotLike(String value) {
            addCriterion("course_time_id not like", value, "courseTimeId");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIdIn(List<String> values) {
            addCriterion("course_time_id in", values, "courseTimeId");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIdNotIn(List<String> values) {
            addCriterion("course_time_id not in", values, "courseTimeId");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIdBetween(String value1, String value2) {
            addCriterion("course_time_id between", value1, value2, "courseTimeId");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIdNotBetween(String value1, String value2) {
            addCriterion("course_time_id not between", value1, value2, "courseTimeId");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekIsNull() {
            addCriterion("day_of_week is null");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekIsNotNull() {
            addCriterion("day_of_week is not null");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekEqualTo(Integer value) {
            addCriterion("day_of_week =", value, "dayOfWeek");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekNotEqualTo(Integer value) {
            addCriterion("day_of_week <>", value, "dayOfWeek");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekGreaterThan(Integer value) {
            addCriterion("day_of_week >", value, "dayOfWeek");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekGreaterThanOrEqualTo(Integer value) {
            addCriterion("day_of_week >=", value, "dayOfWeek");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekLessThan(Integer value) {
            addCriterion("day_of_week <", value, "dayOfWeek");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekLessThanOrEqualTo(Integer value) {
            addCriterion("day_of_week <=", value, "dayOfWeek");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekIn(List<Integer> values) {
            addCriterion("day_of_week in", values, "dayOfWeek");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekNotIn(List<Integer> values) {
            addCriterion("day_of_week not in", values, "dayOfWeek");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekBetween(Integer value1, Integer value2) {
            addCriterion("day_of_week between", value1, value2, "dayOfWeek");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekNotBetween(Integer value1, Integer value2) {
            addCriterion("day_of_week not between", value1, value2, "dayOfWeek");
            return (Criteria) this;
        }

        public Criteria andCourseSchedulIdIsNull() {
            addCriterion("course_schedul_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseSchedulIdIsNotNull() {
            addCriterion("course_schedul_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseSchedulIdEqualTo(Integer value) {
            addCriterion("course_schedul_id =", value, "courseSchedulId");
            return (Criteria) this;
        }

        public Criteria andCourseSchedulIdNotEqualTo(Integer value) {
            addCriterion("course_schedul_id <>", value, "courseSchedulId");
            return (Criteria) this;
        }

        public Criteria andCourseSchedulIdGreaterThan(Integer value) {
            addCriterion("course_schedul_id >", value, "courseSchedulId");
            return (Criteria) this;
        }

        public Criteria andCourseSchedulIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_schedul_id >=", value, "courseSchedulId");
            return (Criteria) this;
        }

        public Criteria andCourseSchedulIdLessThan(Integer value) {
            addCriterion("course_schedul_id <", value, "courseSchedulId");
            return (Criteria) this;
        }

        public Criteria andCourseSchedulIdLessThanOrEqualTo(Integer value) {
            addCriterion("course_schedul_id <=", value, "courseSchedulId");
            return (Criteria) this;
        }

        public Criteria andCourseSchedulIdIn(List<Integer> values) {
            addCriterion("course_schedul_id in", values, "courseSchedulId");
            return (Criteria) this;
        }

        public Criteria andCourseSchedulIdNotIn(List<Integer> values) {
            addCriterion("course_schedul_id not in", values, "courseSchedulId");
            return (Criteria) this;
        }

        public Criteria andCourseSchedulIdBetween(Integer value1, Integer value2) {
            addCriterion("course_schedul_id between", value1, value2, "courseSchedulId");
            return (Criteria) this;
        }

        public Criteria andCourseSchedulIdNotBetween(Integer value1, Integer value2) {
            addCriterion("course_schedul_id not between", value1, value2, "courseSchedulId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}