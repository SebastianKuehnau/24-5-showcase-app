package com.example.application.views.recordbinder;

import com.example.application.data.SamplePerson;
import com.example.application.data.SamplePersonRepository;
import com.example.application.services.SamplePersonService;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@Menu(order = 8, title = "Databinding with Records", icon =
        LineAwesomeIconUrl.COMPACT_DISC_SOLID)
@PageTitle("Databinding with Records")
@Route(value = "record-binder")
public class RecordBinderView extends VerticalLayout {

    private final TextField nameField = new TextField("Name:");

    public record User(String name) {
    }

    public RecordBinderView(SamplePersonRepository personRepository) {

        var name = new TextField("Your name");
        var sayHello = new Button("Say hello");
        var cool = new Checkbox("Vaadin is cool!", Boolean.TRUE);
        var start = new DatePicker("Start date");
        var grid = new Grid<>(SamplePerson.class);
        grid.setItems(personRepository.findAll());
        grid.setColumns("firstName", "lastName", "email");

        add(start);

        var layout = new VerticalLayout(new HorizontalLayout(createButton("Button 1"),
                createButton("Button 2")),createButton("Button 3")
        );
        //add(layout);

        var button = new Button("click");
        button.addClickListener(event -> Notification.show("Button clicked"));
        //add(button);

        var saveButton = new Button("save");
//        add(nameField, saveButton);
        nameField.focus();

        //record User(String name) {}
        var binder = new Binder<>(User.class);
        binder.bind(nameField, "name");
        binder.readRecord(new User(""));

        saveButton.addClickListener(event -> {
            try {
                var savedUser = binder.writeRecord();
                Notification notification = new Notification();
                notification.addClassName("record-view");
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
        setPadding(true);
        setMargin(true);
    }

    private void doSomething(ClickEvent<Button> buttonClickEvent) {

    }

    private Button createButton(String label) {

        Button button = new Button(label);
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        return button;
    }
}
