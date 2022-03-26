//แม่ฮ่องสอน ตี๋

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

public class province6 implements Supplier<FlexMessage> {
        @Override
        public FlexMessage get() {
        final Bubble bubble1 = createBubble("แกงฮังเล",
        "5",
        "https://www.maeban.co.th/upload_images/image/features/curry_original.jpg",
        false);
        final Bubble bubble2 = createBubble("ข่างปอง",
        "5",
        "https://i.pinimg.com/originals/c6/04/f3/c604f36c4fc175a607f2e919308b9c0c.jpg",
        true);
        final Bubble bubble3 = createBubble("ถั่วเน่าเมอะ",
        "5",
        "https://ikasalong.com/wp-content/uploads/2020/04/Thua-nao-moe.jpg",
        true);
        final Bubble bubble4 = createBubble("จอผักกาด",
        "5",
        "https://static.thairath.co.th/media/Dtbezn3nNUxytg04agCxz3X5mgMISDGWXTpu23dHUqsoCG.webp",
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