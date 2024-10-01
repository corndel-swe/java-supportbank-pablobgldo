package com.corndel.supportbank;

import com.corndel.supportbank.controllers.BillController;
import com.corndel.supportbank.controllers.ConvertController;
import com.corndel.supportbank.controllers.TaxController;
import com.github.tomaslanger.chalk.Chalk;
import picocli.CommandLine;

@CommandLine.Command(name = "supportbank", subcommands = {BillController.class, ConvertController.class, TaxController.class})
public class SupportBank implements Runnable {

  public static void main(String[] args) {
    CommandLine commandLine = new CommandLine(new SupportBank());
    int exitCode = commandLine.execute(args);
    System.exit(exitCode);
  }

  @Override
  public void run() {
    System.out.println(Chalk.on("Welcome to the support bank!").green());
  }
}

