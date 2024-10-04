package com.corndel.supportbank.controllers;

import com.corndel.supportbank.services.TaxService;
import picocli.CommandLine.Command;

@Command(name = "salary", subcommands = {TaxService.class})
public class TaxController {
}
