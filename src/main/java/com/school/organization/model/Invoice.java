package com.school.organization.model;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Invoice {

    private Date date;

    private String invoiceNo;

    private String memo;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceLine> lines  = new ArrayList<InvoiceLine>();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public List<InvoiceLine> getLines() {
        return lines;
    }

    public void setLines(List<InvoiceLine> lines) {
        this.lines = lines;
    }
}
