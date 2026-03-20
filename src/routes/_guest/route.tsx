import { Spinner } from "@/components/ui/spinner";
import { usePrivy } from "@privy-io/react-auth";
import {
  createFileRoute,
  Navigate,
  Outlet,
  useNavigate,
} from "@tanstack/react-router";
import { useEffect } from "react";

export const Route = createFileRoute("/_guest")({
  component: GuestGuard,
});

function GuestGuard() {
  const { authenticated, ready } = usePrivy();

  if (!ready) {
    return (
      <div className='min-h-screen flex'>
        <Spinner className='m-auto size-12' />
      </div>
    );
  }

  if (authenticated) {
    return <Navigate to='/dashboard' />;
  }

  return <Outlet />;
}
