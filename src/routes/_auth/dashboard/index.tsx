import { Button } from "@/components/ui/button";
import { flattenUser } from "@/utils/flatten-user";
import { usePrivy } from "@privy-io/react-auth";
import { createFileRoute } from "@tanstack/react-router";
import { useMemo } from "react";

export const Route = createFileRoute("/_auth/dashboard/")({
  component: RouteComponent,
});

function RouteComponent() {
  const { logout, user: privyUser } = usePrivy();
  const user = useMemo(() => flattenUser(privyUser), [privyUser]);
  console.log("User: ", user);
  return (
    <div>
      <Button onClick={logout}>Logout, {user?.email}</Button>
    </div>
  );
}
