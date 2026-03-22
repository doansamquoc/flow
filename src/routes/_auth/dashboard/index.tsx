import { Button } from "@/components/ui/button";
import { magic } from "@/lib/magic";
import { createFileRoute } from "@tanstack/react-router";

export const Route = createFileRoute("/_auth/dashboard/")({
  loader: async () => {
    return await magic.user.getInfo();
  },
  component: RouteComponent,
});

function RouteComponent() {
  const user = Route.useLoaderData();
  return (
    <div>
      <div className='flex justify-between'>
        <span>Hello, {user.email}</span>
        <Button onClick={() => magic.user.logout()}>Đăng xuất</Button>
      </div>
    </div>
  );
}
