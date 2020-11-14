package com.example.demo.model;
import javax.persistence.Column;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name="\"donate\"")
@Data
@NoArgsConstructor
public class Donate {
//    @NonNull
//    @EmbeddedId
//    private DonateId donateId;
//    @Id
    @OneToOne
    @JoinColumn(name = "req_id")
    private Request request;

    @Id
    @Column(name = "donate_id")
    private String donateId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column (name = "donate_date")
    private LocalDateTime donateDate;

    @Column(name = "donate_amount")
    private Integer donateAmount;

    @Column(name = "donate_cancel")
    private LocalDateTime donateCancel;

//    public DonateId getDonateId() {
//        return donateId;
//    }
//
//    public void setDonateId(DonateId donateId) {
//        this.donateId = donateId;
//    }


    public Request getRequest() {
        return request;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public LocalDateTime getDonateDate() {
        return donateDate;
    }

    public void setDonateDate(LocalDateTime donateDate) {
        this.donateDate = donateDate;
    }

    public Integer getDonateAmount() {
        return donateAmount;
    }

    public void setDonateAmount(Integer donateAmount) {
        this.donateAmount = donateAmount;
    }

    public LocalDateTime getDonateCancel() {
        return donateCancel;
    }

    public void setDonateCancel(LocalDateTime donateCancel) {
        this.donateCancel = donateCancel;
    }
}