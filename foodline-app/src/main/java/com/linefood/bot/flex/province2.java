
//เชียงใหม่

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

public class province2 implements Supplier<FlexMessage> {
        @Override
        public FlexMessage get() {
        final Bubble bubble1 = createBubble("ข้าวฟืน",
        "5",
        "https://reviewchiangmai.com/wp-content/uploads/2021/04/Screen-Shot-2564-04-05-at-16.43.48-1024x862.png",
        false);
        final Bubble bubble2 = createBubble("ข้าวซอยน้อย",
        "5",
        "https://i.ytimg.com/vi/EqO7WY1oFB4/maxresdefault.jpg",
        true);
        final Bubble bubble3 = createBubble("ข้าวกั้นจิ้น",
        "5",
        "https://upload.wikimedia.org/wikipedia/commons/9/9d/2013_Khao_kan_chin.jpg",
        true);
        final Bubble bubble4 = createBubble("แคบหมู",
        "5",
        "https://news.mthai.com/app/uploads/2018/09/21-09-18-28.jpg",
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

        