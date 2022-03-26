package com.linefood.bot;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.ReplyMessage;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.StickerMessageContent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.StickerMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import com.linefood.bot.flex.*;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Slf4j
@LineMessageHandler
public class LineBotController {

    @Autowired
    private LineMessagingClient lineMessagingClient;

    @EventMapping
    public void handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        log.info(event.toString());
        TextMessageContent message = event.getMessage();
        handleTextContent(event.getReplyToken(), event, message);
    }

    @EventMapping
    public void handleStickerMessageEvent(MessageEvent<StickerMessageContent> event) {
        log.info(event.toString());
        handleSticker(event.getReplyToken(), event.getMessage());
    }

    private void handleSticker(String replyToken, StickerMessageContent content) {
        reply(replyToken, new StickerMessage(content.getPackageId(), content.getStickerId()));
    }

    @EventMapping
    public void handleDefaultEvent(Event event) {
        System.out.println("event: " + event);
    }

    private void reply(@NonNull String replyToken, @NonNull List<Message> messages) {
        try {
            BotApiResponse response = lineMessagingClient.replyMessage(
                    new ReplyMessage(replyToken, messages)).get();
            log.info("Sent message: " + response);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private void reply(@NonNull String replyToken, @NonNull Message message) {
        reply(replyToken, Collections.singletonList(message));
    }

    private void replyText(@NonNull String replyToken, String message) {
        if (replyToken.isEmpty()) {
            throw new IllegalArgumentException("replyToken must not be empty");
        }
        if (message.length() > 1000) {
            message = message.substring(0, 1000 - 2) + "....";
        }
        this.reply(replyToken, new TextMessage(message));
    }

    private void handleTextContent(String replyToken, Event event, TextMessageContent content) {
        String text = content.getText();

        String flexMenu = "richmenu-7f3ab049e1c434eac55b8aec74ea8689";

        log.info("Got text message from " + replyToken + ": " + text);
        switch (text) {
            case "profile": {
                String userId = event.getSource().getUserId();
                if(userId != null) {
                    lineMessagingClient.getProfile(userId)
                            .whenComplete((profile, throwable) -> {
                                if(throwable != null) {
                                    this.replyText(replyToken, throwable.getMessage());
                                    return;
                                }

                                this.reply(replyToken, Arrays.asList(
                                        new TextMessage("Display name: " + profile.getDisplayName()),
                                        new TextMessage("Status message: " + profile.getStatusMessage())
                                ));

                            });
                }
                break;
            }
            case "Flex Back": {
                String userId = event.getSource().getUserId();
                if(userId != null) {
                    lineMessagingClient.linkRichMenuIdToUser(userId, flexMenu);
                    return;
                }
                break;
            }
            case "อาหารจังหวัดเชียงใหม่": {
                this.reply(replyToken, new province1().get());
                break;
            }
            case "วิธีทำข้าวซอย": {
                this.reply(replyToken, new Food1Pv1().get());
                break;
            }
            case "วิธีทำขนมจีนน้ำเงี้ยว": {
                this.reply(replyToken, new Food2Pv1().get());
                break;
            }
            case "วิธีทำน้ำพริกอ่อง": {
                this.reply(replyToken, new Food3Pv1().get());
                break;
            }
            case "วิธีทำน้ำพริกหนุ่ม": {
                this.reply(replyToken, new Food4Pv1().get());
                break;
            }
            case "อาหารจังหวัดลำพูน": {
                this.reply(replyToken, new province8().get());
                break;
            }
            case "วิธีทำหมูตุ๋นเนื้อลำไย": {
                this.reply(replyToken, new Food1Pv8().get());
                break;
            }
            case "วิธีทำแกงแคไก่": {
                this.reply(replyToken, new Food2Pv8().get());
                break;
            }
            case "วิธีทำแกงโฮะ": {
                this.reply(replyToken, new Food3Pv8().get());
                break;
            }
            case "วิธีทำแกงหยวกกล้วย": {
                this.reply(replyToken, new Food4Pv8().get());
                break;
            }
            case "อาหารจังหวัดอุตรดิตถ์": {
                this.reply(replyToken, new province9().get());
                break;
            }
            case "วิธีทำหมี่พันลับแล": {
                this.reply(replyToken, new Food1Pv9().get());
                break;
            }
            case "วิธีทำข้าวพันผัก": {
                this.reply(replyToken, new Food2Pv9().get());
                break;
            }
            case "วิธีทำน้ำยาปลาตะโกก": {
                this.reply(replyToken, new Food3Pv9().get());
                break;
            }
            case "อาหารจังหวัดเชียงราย" : {
                this.reply(replyToken, new province2().get());
                break;
            }
            case "วิธีทำข้าวฟืน" : {
                this.reply(replyToken, new Food1Pv2().get());
                break;
            }
            case "วิธีทำข้าวซอยน้อย" : {
                this.reply(replyToken, new Food2Pv2().get());
                break;
            }
            case "วิธีทำข้าวกั้นจิ้น" : {
                this.reply(replyToken, new Food3Pv2().get());
                break;
            }
            case "วิธีทำแคบหมู" : {
                this.reply(replyToken, new Food4Pv2().get());
                break;
            }
            case "อาหารจังหวัดน่าน" : {
                this.reply(replyToken, new province3().get());
                break;
            }
            case "วิธีทำแกงเห็ดเผาะ" : {
                this.reply(replyToken, new Food1Pv3().get());
                break;
            }
            case "วิธีทำแกงแคกบ" : {
                this.reply(replyToken, new Food2Pv3().get());
                break;
            }
            case "วิธีทำน้ำพริกเห็ดด่าน" : {
                this.reply(replyToken, new Food3Pv3().get());
                break;
            }
            case "วิธีทำส้ามะเขือ" : {
                this.reply(replyToken, new Food4Pv3().get());
                break;
            }
            case "อาหารจังหวัดพะเยา" : {
                this.reply(replyToken, new province4().get());
                break;
            }
            case "วิธีทำแกงเห็ดห้า" : {
                this.reply(replyToken, new Food1Pv4().get());
                break;
            }
            case "วิธีทำคั่วถั่วเน่า" : {
                this.reply(replyToken, new Food2Pv4().get());
                break;
            }
            case "วิธีทำยำฮก" : {
                this.reply(replyToken, new Food3Pv4().get());
                break;
            }
            case "วิธีทำไข่ป่าม" : {
                this.reply(replyToken, new Food4Pv4().get());
                break;
            }
            case "อาหารจังหวัดแพร่" : {
                this.reply(replyToken, new province5().get());
                break;
            }
            case "วิธีทำตำเตา" : {
                this.reply(replyToken, new Food1Pv5().get());
                break;
            }
            case "วิธีทำหลู้หมู" : {
                this.reply(replyToken, new Food2Pv5().get());
                break;
            }
            case "วิธีทำขนมจีนน้ำหมู" : {
                this.reply(replyToken, new Food4Pv5().get());
                break;
            }
            case "อาหารจังหวัดแม่ฮ่องสอน": {
                this.reply(replyToken, new province6().get());
                break;
            }
            case "วิธีทำแกงฮังเล": {
                this.reply(replyToken, new Food1Pv6().get());
                break;
            }
            case "วิธีทำข่างปอง": {
                this.reply(replyToken, new Food2Pv6().get());
                break;
            }
            case "วิธีทำถั่วเน่าเมอะ": {
                this.reply(replyToken, new Food3Pv5().get());
                break;
            }
            case "วิธีทำจอผักกาด": {
                this.reply(replyToken, new Food4Pv6().get());
                break;
            }
            case "อาหารจังหวัดลำปาง": {
                this.reply(replyToken, new province7().get());
                break;
            }
            case "วิธีทำลาบลำปาง": {
                this.reply(replyToken, new Food1Pv7().get());
                break;
            }
            case "วิธีทำแกงแคไก่เมือง": {
                this.reply(replyToken, new Food2Pv7().get());
                break;
            }
            case "วิธีทำหลามบอน": {
                this.reply(replyToken, new Food3Pv7().get());
                break;
            }
            case "วิธีทำแกงแคหอย": {
                this.reply(replyToken, new Food4Pv7().get());
                break;        
            }
            
            default:
                this.reply(replyToken, new FalseWord().get());
                break;
        }
    }

}


//ใส่วิธีทำชื่ออาหาร ใส่class