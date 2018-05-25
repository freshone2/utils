package com.common.model.bo.order;

/**
 * @Package: pecker.model.bo.order
 * @Description:
 * @author: jklofs
 * @date: 2018/3/30 上午10:02
 */
public class InvoiceBo {
    private String title;
    private String dutyParagraph;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDutyParagraph() {
        return dutyParagraph;
    }

    public void setDutyParagraph(String dutyParagraph) {
        this.dutyParagraph = dutyParagraph;
    }

    @Override
    public String toString() {
        return "InvoiceBo{" +
                "title='" + title + '\'' +
                ", dutyParagraph='" + dutyParagraph + '\'' +
                '}';
    }
}
