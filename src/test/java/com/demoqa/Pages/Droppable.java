package com.demoqa.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.BaseClass.BaseClass;

import junit.framework.Assert;

public class Droppable extends BaseClass {

	@FindBy(id = "draggable")
	WebElement from;

	@FindBy(id = "droppable")
	WebElement to;

	public Droppable() {

		PageFactory.initElements(driver, this);
	}

	public void verifyDragAndDrop() {

		// Actions class method to drag and drop
		Actions builder = new Actions(driver);

		// Perform drag and drop
		builder.keyDown(Keys.CONTROL)
        .click(from)
        .dragAndDrop(from, to)
        .keyUp(Keys.CONTROL);

        Action selected = builder.build();
        selected.perform();

		// verify text changed in to 'Drop here' box
		String textTo = to.getText();
		Assert.assertEquals(textTo, "Dropped!");

		if (textTo.equals("Dropped!"))
			System.out.println("PASS: Source is dropped to target as expected");
		else
			System.out.println("FAIL: Source couldn't be dropped to target as expected");		

	}
}
