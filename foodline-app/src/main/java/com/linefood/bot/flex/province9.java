//นน
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

public class province9 implements Supplier<FlexMessage> {
        @Override
        public FlexMessage get() {
        final Bubble bubble1 = createBubble("หมี่พันลับแล",
        "5",
        "https://www.greenery.org/wp-content/uploads/2021/01/%E0%B8%A3%E0%B8%AA%E0%B8%9A%E0%B9%89%E0%B8%B2%E0%B8%99_%E0%B8%AB%E0%B8%A1%E0%B8%B5%E0%B9%88%E0%B8%9E%E0%B8%B1%E0%B8%99-9-1.jpg",
        false);
        final Bubble bubble2 = createBubble("ข้าวพันผัก ",
        "5",
        "https://www.dailynews.co.th/admin/upload/20170114/news_KWEjkHOKSw130734_533.jpg",
        true);
        final Bubble bubble3 = createBubble("น้ำยาปลาตะโกก",
        "5",
        "https://f.ptcdn.info/188/062/000/plziq5lkig8YBcdB35H-o.jpg",
        true);
        

            final Carousel carousel = Carousel.builder()
                    .contents(asList(bubble1, bubble2, bubble3))
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