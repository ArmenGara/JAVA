package com.armen.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.armen.safetravels.models.Expenses;
import com.armen.safetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
		//add the expenses to the Repository //
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
	//Returns all expenses
	public List<Expenses> allExpenses(){
		return expenseRepository.findAll();
	}
	
	// Create a expenses
	public Expenses createExpense(Expenses ex) {
		return expenseRepository.save(ex);
	}
	
    // retrieves a travel
    public Expenses findExpense(Long id) {
        Optional<Expenses> optionalExpenses = expenseRepository.findById(id);
        if(optionalExpenses.isPresent()) {
            return optionalExpenses.get();
        } else {
            return null;
        }
    }
    
    // updates a travel
    public Expenses updateExpense(Expenses updatedExpenses) {
    	return expenseRepository.save(updatedExpenses);
    }
    
    
    // deletes a travel
    public void deleteExpense(Long id) {
    	expenseRepository.deleteById(id);
    }
}
