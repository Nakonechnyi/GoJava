package com.goit.kickstarter.glmax.model;

import java.util.*;

import com.goit.kickstarter.glmax.controller.Position;
import com.goit.kickstarter.glmax.enteties.Category;
import com.goit.kickstarter.glmax.enteties.Entetie;
import com.goit.kickstarter.glmax.enteties.PaymentVariant;
import com.goit.kickstarter.glmax.enteties.Project;
import com.goit.kickstarter.glmax.enteties.Quote;
import com.goit.kickstarter.glmax.pages.CategoryPage;
import com.goit.kickstarter.glmax.pages.PaymentPage;
import com.goit.kickstarter.glmax.pages.ProjectPage;
import com.goit.kickstarter.glmax.pages.QuestionPage;

public class LocalDataSource implements DataSource {
	private ArrayList<Category> categories = new ArrayList<Category>();
	private HashMap<Category, ArrayList<Project>> projects = new HashMap<Category, ArrayList<Project>>();
	private HashMap<Project, PaymentVariant> payments = new HashMap<Project, PaymentVariant>();

	public LocalDataSource() {
		for (int i = 0; i < 6; i++) {
			Category category = new Category(i, "Category " + i);
			categories.add(category);
			projects.put(category, new ArrayList<Project>());
			for (int j = 0; j < 6; j++) {
				Project project = new Project(i * 10 + j, "project " + i * j,
						"short description of project" + i * j, i * j * 10, i
								* j, i * j / 2, "some histry",
						"www.youtube.com/?video=" + i * 10 + j + "LkmSk/", null);
				projects.get(category).add(project);
				PaymentVariant paymentVariants = new PaymentVariant(i * 100
						+ j * 10, "payment");
				payments.put(project, paymentVariants);
			}
		}
	}

	@Override
	public ArrayList<Category> getCategoriesList() {
		return categories;
	}

	@Override
	public Entetie getSomeQuote() {
		return new Quote(12,"some qoute");
	}

	@Override
	public ArrayList<Project> getProjectsList(int categoryIndex) {
		return projects.get(categories.get(categoryIndex - 1));
	}

	@Override
	public String getCategoryName(int categoryIndex) {
		return categories.get(categoryIndex - 1).getName();
	}

	@Override
	public Project getProject(int categoryIndex, int projectIndex) {
		return getProjectsList(categoryIndex).get(projectIndex - 1);
	}

	@Override
	public void persistData() {
		// TODO Auto-generated method stub

	}

	@Override
	public PaymentVariant getpaymentVariants(Integer categoryIndex,
			Integer projectIndex) {
		return payments.get(getProjectsList(categoryIndex)
				.get(projectIndex - 1));
	}


	@Override
	public ArrayList<Entetie> getEntetiesList(Position next, int id) {
		ArrayList<Entetie> result = new ArrayList<Entetie>();
		switch (next) {
		case Main:
			result.addAll(categories);
			break;
		case Category:
			result.addAll(getProjectsList(id));
			break;
		case Project:
			result = null;
			break;
		case Payment:
			result = null;
			break;
		case Question:
			result = null;
			break;
		}
		return result;
	}


}
