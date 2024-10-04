package com.corndel.supportbank.controllers;

import com.corndel.supportbank.services.ConvertService;
import com.corndel.supportbank.services.CurrencyListService;
import picocli.CommandLine.Command;

@Command(name = "currency", subcommands = {ConvertService.class, CurrencyListService.class})
public class ConvertController {
}