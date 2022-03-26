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

public class province8 implements Supplier<FlexMessage> {
        @Override
        public FlexMessage get() {
                final Bubble bubble1 = createBubble("หมูตุ๋นเนื้อลำไย",
                "5",
                "https://img.wongnai.com/p/1968x0/2020/04/19/1ed74096cec34f1ab303272ad4e762f1.jpg",
                false);
                final Bubble bubble2 = createBubble("แกงแคไก่ ",
                "5",
                "https://cooking.teenee.com/side-dish/img8/5087.jpg",
                true);
                final Bubble bubble3 = createBubble("แกงโฮะ",
                "5",
                "https://farm3.staticflickr.com/2947/15287933559_14bbef7c51_z.jpg",
                true);
                final Bubble bubble4 = createBubble("แกงหยวกกล้วย",
                "5",
                "https://img-global.cpcdn.com/recipes/68ff591b3e2ecfbb/680x482cq70/%E0%B8%A3%E0%B8%9B-%E0%B8%AB%E0%B8%A5%E0%B8%81-%E0%B8%82%E0%B8%AD%E0%B8%87-%E0%B8%AA%E0%B8%95%E0%B8%A3-%E0%B9%81%E0%B8%81%E0%B8%87%E0%B8%AB%E0%B8%A2%E0%B8%A7%E0%B8%81%E0%B8%81%E0%B8%A5%E0%B8%A7%E0%B8%A2%E0%B9%83%E0%B8%AA%E0%B9%84%E0%B8%81%E0%B8%9A%E0%B8%B2%E0%B8%99.jpg",
                true);
        ;
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

        