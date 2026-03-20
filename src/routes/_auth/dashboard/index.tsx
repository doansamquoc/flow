import { Button } from "@/components/ui/button";
import { usePrivy } from "@privy-io/react-auth";
import { createFileRoute } from "@tanstack/react-router";

export const Route = createFileRoute("/_auth/dashboard/")({
  component: RouteComponent,
});

function RouteComponent() {
  const { logout, user } = usePrivy();
  console.log("User: ", user);
  return (
    <div>
      <Button onClick={logout}>
        Logout,{" "}
        {user?.linkedAccounts.find((account) => "email" in account)?.email}
      </Button>
    </div>
  );
}
