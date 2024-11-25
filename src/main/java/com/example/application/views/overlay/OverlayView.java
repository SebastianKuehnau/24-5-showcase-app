package com.example.application.views.overlay;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Menu(order = 7, title = "Overlay in Select")
@PageTitle("Overlay Configuration in Select")
@Route(value = "overlay")
public class OverlayView extends HorizontalLayout {

    public OverlayView() {

        var select = new Select<>();
        select.setItems("North",
                "West",
                "South",
                "East");
        select.setNoVerticalOverlap(true);
        select.setOverlayWidth("100px");


        FormLayout formLayout = new FormLayout();
        formLayout.addFormItem(select, "Cardinal");
        add(formLayout);

        setPadding(true);
        addClassName(LumoUtility.JustifyContent.CENTER);
    }
}
