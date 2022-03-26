// แพร่ เต้

package com.linefood.bot.flex;

import com.linecorp.bot.model.message.FlexMessage;
import com.linecorp.bot.model.message.flex.component.*;
import com.linecorp.bot.model.message.flex.container.Bubble;
import com.linecorp.bot.model.message.flex.container.Carousel;
import com.linecorp.bot.model.message.flex.unit.FlexFontSize;
import com.linecorp.bot.model.message.flex.unit.FlexGravity;
import com.linecorp.bot.model.message.flex.unit.FlexLayout;
import com.linecorp.bot.model.message.flex.unit.FlexMarginSize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static java.util.Arrays.asList;

public class province5 implements Supplier<FlexMessage> {
        @Override
        public FlexMessage get() {
        final Bubble bubble1 = createBubble("ตำเตา",
        "5",
        "https://sangkae.files.wordpress.com/2013/02/e0b8ade0b8b2e0b8abe0b8b2e0b8a3e0b980e0b8abe0b899e0b8b7e0b8ad_e0b981e0b89ee0b8a3e0b988_e0b895e0b98be0b8b3e0b980e0b895e0b8b2.jpg",
        false);
        final Bubble bubble2 = createBubble("หลู้หมู ",
        "5",
        "https://static.thairath.co.th/media/4DQpjUtzLUwmJZZSCIu3J3tHG3Yq4R7tNFTSKnYtmrm6.jpg",
        true);
        final Bubble bubble3 = createBubble("น้ำพริกอ่อง",
        "5",
        "https://www.pim.in.th/images/all-side-dish-nampric/nampric-ong/nam-pric-ong-10.JPG",
        true);
        final Bubble bubble4 = createBubble("ขนมจีนน้ำหมู",
        "5",
        "https://pbs.twimg.com/media/ESuoOynUcAAZVm_.jpg",
        true);
        
            final Carousel carousel = Carousel.builder()
                    .contents(asList(bubble1, bubble2, bubble3, bubble4))
                    .build();
            return new FlexMessage("Catalogue", carousel);
        }
    
        private Bubble createBubble(String title, String price, String imageURL, Boolean isOutOfStock) {
            final Image heroBlock = createHeroBlock(imageURL);
            final Box bodyBlock = createBodyBlock(title, price, isOutOfStock);
            return Bubble.builder()
                    .hero(heroBlock)
                    .body(bodyBlock)
                    .build();
        }
    
        
    
        private Image createHeroBlock(String imageURL) {
            return Image.builder()
                    .size(Image.ImageSize.FULL_WIDTH)
                    .aspectRatio(Image.ImageAspectRatio.R20TO13)
                    .aspectMode(Image.ImageAspectMode.Cover)
                    .url(imageURL)
                    .build();
        }
    
        private Box createBodyBlock(String title, String price, Boolean isOutOfStock) {
            final Text titleBlock = Text.builder()
                    .text(title)
                    .gravity(FlexGravity.CENTER)
                    .wrap(true)
                    .weight(Text.TextWeight.BOLD)
                    .size(FlexFontSize.XL).build();
        
    
            FlexComponent[] flexComponents = {titleBlock};
            List<FlexComponent> listComponent = new ArrayList<>(Arrays.asList(flexComponents));
    
            return Box.builder()
                    .layout(FlexLayout.VERTICAL)
                    .spacing(FlexMarginSize.SM)
                    .contents(listComponent)
                    .build();
        }

    }