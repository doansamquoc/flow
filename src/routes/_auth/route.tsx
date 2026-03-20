import { Spinner } from "@/components/ui/spinner";
import { usePrivy } from "@privy-io/react-auth";
import { createFileRoute, Outlet, useNavigate } from "@tanstack/react-router";

export const Route = createFileRoute("/_auth")({
  component: AuthGuard,
});

function AuthGuard() {
  const { authenticated, ready } = usePrivy();
  const navigate = useNavigate();

  if (!ready) {
    return (
      <div className='min-h-screen flex'>
        <Spinner className='m-auto size-12' />
      </div>
    );
  }

  if (!authenticated) return navigate({ to: "/login" });

  return <Outlet />;
}
