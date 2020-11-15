package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name="\"group_detail\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDetail {
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gc_id")
    private String gcId;

    @Column(name = "gc_name")
    private String gcName;

    @ManyToOne
    @JoinColumn(name = "g_id")
    private Group group;

    public String getGcId() {
        return gcId;
    }

    public void setGcId(String gcId) {
        this.gcId = gcId;
    }

    public String getGcName() {
        return gcName;
    }

    public void setGcName(String gcName) {
        this.gcName = gcName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}