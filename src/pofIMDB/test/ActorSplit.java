package pofIMDB.test;

public class ActorSplit {

	public static void main(String[] args) {
		String actorsAndRoles = "Orlando Bloom_Legolas:Billy Boyd_Pippin:Ian Holm_Bilbo";

		validateActorsAndRoles(actorsAndRoles);
	}
	
	private static void validateActorsAndRoles(String actorsAndRoles) {
		String[] actorRolePair = actorsAndRoles.split(":");
		for(int i = 0; i < actorRolePair.length; i++) {
			validateActorRolePair(actorRolePair[i]);
		}
	}
	private static void validateActorRolePair(String pair) {
		String[] arPair = pair.split("_");
		validateActorAndRole(arPair);
	}
	
	private static void validateActorAndRole(String[] arPair) {
		String actor = arPair[0];
		String role = arPair[1];
		System.out.println(actor + " " + role);
	}
}
