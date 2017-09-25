import java.util.Scanner;


public class BlockChainDriver {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		BlockChain chain = new BlockChain(Integer.parseInt(args[0]));
		String command;

		while(command != "quit"){
			System.out.println(chain.toString());
			System.out.print("Command? ");
			command = input.next();
			if(command == "mine"){
				System.out.print("Amount transferred? ");
				int amt = Integer.parseInt(input.next());
				Block minedBlock = chain.mine(amt);
				System.out.print("amount = "+ Integer.toString(amt)+ "nonce = %l" + Long.toString(minedBlock.nonce));


			}
			else if(command == "append"){
				System.out.print("Amount transferred? ");
				int amt = Integer.parseInt(input.next());
				System.out.print("Nonce? ");
				long nonce = Long.parseLong(input.next());
				Block newBlock = new Block(chain.last.data.num+1, amt, chain.last.data.curHash, nonce);
				chain.append(newBlock);
			}
			else if(command == "remove"){
				chain.removeLast();

			}
			else if(command == "check"){
				boolean validity = chain.isValidBlockChain();
				if(validity){
					System.out.println("Chain is valid!");
				}
				else{System.out.println("Chain is not valid!");
				}
			}
			else if(command == "report"){
				chain.printBalances();
			}

			else if(command == "help"){
				System.out.println("Valid commands:");
				System.out.println("    mine: discovers the nonce for a given transaction");
				System.out.println("    append: appends a new block onto the end of the chain");
				System.out.println("    remove: removes the last block from the end of the chain");
				System.out.println("    check: checks that the block chain is valid");
				System.out.println("    report: reports the balances of Alice and Bob");
				System.out.println("    help: prints this list of commands");
				System.out.println("    quit: quits the program");
			}




    		
    	}
	}
}
    	
    	
  
