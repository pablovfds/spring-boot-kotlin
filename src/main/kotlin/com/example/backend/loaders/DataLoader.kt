package com.example.backend.loaders

import com.example.backend.models.Problem
import com.example.backend.repositories.ProblemRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class DataLoader
    constructor(private var problemRepository: ProblemRepository): ApplicationRunner {

    override fun run(args: ApplicationArguments?) {

        for (i in 0..10) {
            problemRepository.save(Problem("Print input " + i, "Print the program input " + i))
        }
    }
}