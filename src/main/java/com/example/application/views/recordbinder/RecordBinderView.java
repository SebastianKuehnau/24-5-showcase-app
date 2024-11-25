package com.example.application.views.recordbinder;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Menu(order = 8, title = "Databinding with Records")
@PageTitle("Databinding with Records")
@Route("record-binder")
@RouteAlias("")
public class RecordBinderView extends VerticalLayout {

    private final TextField nameField = new TextField("Name:");
    private final Button saveButton = new Button("save");

    public record User(String name) {
    }

    public RecordBinderView() {

        add(nameField, saveButton);
        nameField.focus();

        //record User(String name) {}
        var binder = new Binder<>(User.class);
        binder.bind(nameField, "name");
        binder.readRecord(new User(""));

        saveButton.addClickListener(event -> {
            try {
                var savedUser = binder.writeRecord();
                Notification notification = new Notification();
                notification.setText("\uD83E\uDD73 \uD83C\uDF89 \uD83C\uDF8A Hello " + savedUser.name() + "! \uD83E\uDD73 \uD83C\uDF89 \uD83C\uDF8A");
                notification.setDuration(3000);
                notification.setPosition(Notification.Position.BOTTOM_STRETCH);
                notification.open();
                notification.addOpenedChangeListener(openedChangeEvent -> {
                        if (!openedChangeEvent.isOpened())
                            nameField.clear();
                    }
                );
            } catch (ValidationException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
