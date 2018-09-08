package com.example.mydatabase.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by ryan on 18-8-27.
 */

@Entity
public class Photo {

    @Id(autoincrement = true)
    private Long id;

    private int drawable;

    private Long cardId;

    public Long getCardId() {
        return this.cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public int getDrawable() {
        return this.drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 487876905)
    public Photo(Long id, int drawable, Long cardId) {
        this.id = id;
        this.drawable = drawable;
        this.cardId = cardId;
    }

    @Generated(hash = 1043664727)
    public Photo() {
    }

   

}
