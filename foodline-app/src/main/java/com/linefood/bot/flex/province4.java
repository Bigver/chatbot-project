
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

public class province4 implements Supplier<FlexMessage> {
        @Override
        public FlexMessage get() {
        final Bubble bubble1 = createBubble("แกงเห็ดห้า",
        "5",
        "https://woodychannel.com/wp-content/uploads/2013/07/p153.jpg",
        false);
        final Bubble bubble2 = createBubble("ยำฮก",
        "5",
        "https://img-global.cpcdn.com/recipes/7a8680b835dbd2c8/680x482cq70/%E0%B8%A3%E0%B8%9B-%E0%B8%AB%E0%B8%A5%E0%B8%81-%E0%B8%82%E0%B8%AD%E0%B8%87-%E0%B8%AA%E0%B8%95%E0%B8%A3-%E0%B8%A2%E0%B8%B3%E0%B8%AE%E0%B8%81%E0%B8%87%E0%B8%A7-%E0%B8%97%E0%B8%B2%E0%B8%87%E0%B9%80%E0%B8%AB%E0%B8%99%E0%B8%AD-%E0%B8%A2%E0%B8%B3%E0%B8%A3%E0%B8%81%E0%B8%A7%E0%B8%A7.jpg",
        true);
        final Bubble bubble3 = createBubble("คั่วถั่วเน่า",
        "5",
        "https://pitchaya.net/wp-content/uploads/2011/02/%E0%B8%84%E0%B8%B1%E0%B9%88%E0%B8%A7%E0%B8%96%E0%B8%B1%E0%B9%88%E0%B8%A7%E0%B9%80%E0%B8%99%E0%B9%88%E0%B8%B26.jpg",
        true);
        final Bubble bubble4 = createBubble("ไข่ป่าม",
        "5",
        "https://img.kapook.com/u/surauch/movie2/bake-egg.jpg",
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

        