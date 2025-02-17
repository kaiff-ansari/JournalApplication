package com.MyProject.JournalApplication.Entity;

import com.MyProject.JournalApplication.enums.Sentiment;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection  = "journalEntries") // it is connected with journal fields row in db
@Data // it is mixture of getters setters to string and more
@NoArgsConstructor
public class JournalEntry {
    @Id // primary key
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime date;
    private Sentiment sentiment;

}
