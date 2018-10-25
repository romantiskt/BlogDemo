package com.wang.advance.tasks.design.agency;

/**
 * Created by romantiskt on 2018/10/25.
 * 中介者模式
 */

public class Agencyer implements AbstractAgency {

    Worker teacher;
    Worker doctor;

    public Agencyer(Worker teacher, Worker doctor) {
        this.teacher = teacher;
        this.doctor = doctor;
    }

    @Override
    public void teach() {
        this.teacher.doSomeThing();
    }

    @Override
    public void seeDoctor() {
        this.doctor.doSomeThing();
    }
}
