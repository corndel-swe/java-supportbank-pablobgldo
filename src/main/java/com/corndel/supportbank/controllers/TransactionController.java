package com.corndel.supportbank.controllers;

import com.corndel.supportbank.services.ConvertService;
import picocli.CommandLine.Command;

@Command(name = "currency", subcommands = {SummariseService.class, ListService.class})
public class TransactionController {
}
