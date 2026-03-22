import { magic } from "@/lib/magic";

const Dashboard = async () => {
  const user = await magic.user.getInfo();
  return <div>Hello, {user.email}</div>;
};

export default Dashboard;
