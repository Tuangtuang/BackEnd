package com.example.demo.model.entity;

import java.sql.Timestamp;
import java.util.Date;

public class OtherInfo {
    private Integer id;

    private Timestamp passport;

    private Integer passportState;

    private Timestamp vaccine;

    private Integer vaccineState;

    private Timestamp deposit;

    private Integer depositState;

    private Timestamp dormitory;

    private Integer dormitoryState;

    private Timestamp test;

    private Integer testState;

    private Timestamp fee;

    private Integer feeState;

    private Timestamp document;

    private Integer documentState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPassport() {
        return passport;
    }

    public void setPassport(Timestamp passport) {
        this.passport = passport;
    }

    public Integer getPassportState() {
        return passportState;
    }

    public void setPassportState(Integer passportState) {
        this.passportState = passportState;
    }

    public Date getVaccine() {
        return vaccine;
    }

    public void setVaccine(Timestamp vaccine) {
        this.vaccine = vaccine;
    }

    public Integer getVaccineState() {
        return vaccineState;
    }

    public void setVaccineState(Integer vaccineState) {
        this.vaccineState = vaccineState;
    }

    public Date getDeposit() {
        return deposit;
    }

    public void setDeposit(Timestamp deposit) {
        this.deposit = deposit;
    }

    public Integer getDepositState() {
        return depositState;
    }

    public void setDepositState(Integer depositState) {
        this.depositState = depositState;
    }

    public Date getDormitory() {
        return dormitory;
    }

    public void setDormitory(Timestamp dormitory) {
        this.dormitory = dormitory;
    }

    public Integer getDormitoryState() {
        return dormitoryState;
    }

    public void setDormitoryState(Integer dormitoryState) {
        this.dormitoryState = dormitoryState;
    }

    public Date getTest() {
        return test;
    }

    public void setTest(Timestamp test) {
        this.test = test;
    }

    public Integer getTestState() {
        return testState;
    }

    public void setTestState(Integer testState) {
        this.testState = testState;
    }

    public Date getFee() {
        return fee;
    }

    public void setFee(Timestamp fee) {
        this.fee = fee;
    }

    public Integer getFeeState() {
        return feeState;
    }

    public void setFeeState(Integer feeState) {
        this.feeState = feeState;
    }

    public Date getDocument() {
        return document;
    }

    public void setDocument(Timestamp document) {
        this.document = document;
    }

    public Integer getDocumentState() {
        return documentState;
    }

    public void setDocumentState(Integer documentState) {
        this.documentState = documentState;
    }
}