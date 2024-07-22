package org.hantel.social_media_platform.config;

import java.util.UUID;

import org.hantel.social_media_platform.document.UuidIdentifiedDocument;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class UuidIdentifiedEntityEventListener extends AbstractMongoEventListener<UuidIdentifiedDocument> {
    
    @Override
    public void onBeforeConvert(BeforeConvertEvent<UuidIdentifiedDocument> event) {
        
        super.onBeforeConvert(event);
        UuidIdentifiedDocument entity = event.getSource();
        
        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID());
        } 
    }    
}
