package com.example.backend.repositories

import com.example.backend.models.Problem
import org.springframework.data.repository.CrudRepository

interface ProblemRepository : CrudRepository<Problem, Long>